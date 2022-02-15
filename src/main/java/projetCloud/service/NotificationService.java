package projetCloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import projetCloud.model.Notification;
import projetCloud.repository.NotificationRepository;

@Service
public class NotificationService {
    

    @Autowired
    private NotificationRepository notificationRepository;
    
    public NotificationService(){

    }

    public void createNotification(Notification notification){
        notificationRepository.save(notification);
    }
}