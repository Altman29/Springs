package a08;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
@Slf4j
@Scope("session")
public class BeanForSession {
    @PreDestroy
    public void destroy() {
        log.debug("destroy");
    }
}
