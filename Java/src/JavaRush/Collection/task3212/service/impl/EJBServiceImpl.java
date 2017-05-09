package JavaRush.Collection.task3212.service.impl;

import JavaRush.Collection.task3212.service.Service;

public class EJBServiceImpl implements Service {

    @Override
    public void execute() {
        System.out.println("Executing EJBService");
    }

    @Override
    public String getName() {
        return "EJBService";
    }

}
