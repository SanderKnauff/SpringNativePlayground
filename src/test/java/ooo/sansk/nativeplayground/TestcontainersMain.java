package ooo.sansk.nativeplayground;

import org.springframework.boot.SpringApplication;

public class TestcontainersMain {
    public static void main(String[] args) {
        SpringApplication.from(NativePlaygroundApplication::main)
                .with(TestcontainersConfiguration.class)
                .run(args);
    }
}
