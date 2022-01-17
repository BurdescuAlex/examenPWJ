package com.example.examen.Repository;

import com.example.examen.Model.Payment;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
    Iterable<Payment> findAll(Example<Payment> of);
    
    Iterable<Payment> findAllByStatus(Payment.paymentStatus status);

    Iterable<Payment> findAllByType(Payment.paymentType type);

    Iterable<Payment> findAllByStatusAndType(Payment.paymentStatus status, Payment.paymentType type);
}
