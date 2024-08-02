package com.example.kafka_ex;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @KafkaListener(topics = "operation_topic", groupId = "group_id")
    public void consume(OperationMessage message) {
        if (message == null || message.getOperation() == null) {
            System.err.println("Invalid operation or message is null");
            return;
        }
        System.out.println("Consumed message: " + message);
        int operand = message.getOperand();
        String operation = message.getOperation();

        boolean result = false;
        switch (operation) {
            case "fib":
                result = isFibonacci(operand);
                break;
            case "prime":
                result = isPrime(operand);
                break;
            case "fibPrime":
                result = isFibonacci(operand) && isPrime(operand);
                break;
            default:
                System.out.println("Error: Invalid operation");
                return;
        }

        System.out.println("Operand: " + operand + ", Operation: " + operation + ", Result: " + result);
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    private boolean isFibonacci(int n) {
        int x1 = 5 * n * n + 4;
        int x2 = 5 * n * n - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    private boolean isPerfectSquare(int n) {
        int s = (int) Math.sqrt(n);
        return s * s == n;
    }
}
