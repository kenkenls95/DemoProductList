package application.jobs;

import application.constant.StatusOrderConstant;
import application.data.model.Order;
import application.data.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

@Component
public class ScheduledTasks {

    @Autowired
    private OrderService orderService;

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

//    @Scheduled(fixedRate = 2000)
//    public void scheduleTaskWithFixedRate() {
//        logger.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
//    }
//
//    @Scheduled(fixedDelay = 2000)
//    public void scheduleTaskWithFixedDelay() {
//        logger.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException ex) {
//            logger.error("Ran into an error {}", ex);
//            throw new IllegalStateException(ex);
//        }
//    }
//
//    @Scheduled(fixedRate = 2000, initialDelay = 5000)
//    public void scheduleTaskWithInitialDelay() {
//        logger.info("Fixed Rate Task with Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
//    }

    @Scheduled(cron = "0 59 23 * * *")
    public void scheduleTaskWithCronExpression() {
        System.out.println("==============================");
        logger.info("Cron Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));

        try {
            ArrayList<Order> orders = orderService.getListOrderByStatusId(StatusOrderConstant.not_active);
            if(orders != null){
                for(Order o : orders){
                    orderService.deleteOrder(o.getId());
                }
                logger.info("Total order not active have been removed " + orders.size());
            }else {
                logger.info("No orders were found !");
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
    }

}

