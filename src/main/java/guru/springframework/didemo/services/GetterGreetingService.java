package guru.springframework.didemo.services;

import org.springframework.stereotype.Service;

@Service
public class GetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting(){
        return "hello from getterGreetingService";
    }
}
