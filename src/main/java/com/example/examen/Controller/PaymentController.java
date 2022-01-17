package com.example.examen.Controller;


import com.example.examen.Model.Payment;
import com.example.examen.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping("/add")
    public ResponseEntity<Void> addPayment(Payment.paymentType type, String customer, double amount, Payment.paymentStatus status){
        if(paymentService.addPayment(type,customer,amount,status))
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancelPayment(long id)
    {
        String response = paymentService.cancelPayment(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get")
    public ResponseEntity<Iterable<Payment>> getList(
            @RequestParam(name = "type", required = false) Payment.paymentType type,
            @RequestParam(name = "status",required = false) Payment.paymentStatus status){
        return ResponseEntity.ok(paymentService.list(type,status));
    }
}
