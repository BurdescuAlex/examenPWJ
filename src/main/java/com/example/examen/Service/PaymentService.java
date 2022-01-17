package com.example.examen.Service;

import com.example.examen.Model.Payment;
import com.example.examen.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    public Boolean addPayment(Payment.paymentType type, String customer, double amount, Payment.paymentStatus status){
        if(amount < 0)
            return false;
        try{
            Payment newPayment = new Payment(type,customer,amount,status);
            paymentRepository.save(newPayment);
            return true;
        }
        catch (RuntimeException e)
        {
            return false;
        }
    }

    public String cancelPayment(long id)
    {
        Optional<Payment> payment = paymentRepository.findById(id);
        if(payment.isPresent())
        {
            if(payment.get().getStatus()== Payment.paymentStatus.CANCELLED)
            {
                return "The Payment is already cancelled";
            }
            payment.get().setStatus(Payment.paymentStatus.CANCELLED);
            paymentRepository.save(payment.get());
            return "Ok";
        }
        else{
            return "The payment does not exist";
        }
    }

    public Iterable<Payment> list(Payment.paymentType type, Payment.paymentStatus status)
    {
        if(type == null)
        {
            if(status == null)
                return paymentRepository.findAll();
            return paymentRepository.findAllByStatus(status);
        }
        else
        {
            if(status == null) {
                return paymentRepository.findAllByType(type);
            }
            return paymentRepository.findAllByStatusAndType(status,type);
        }
    }
}
