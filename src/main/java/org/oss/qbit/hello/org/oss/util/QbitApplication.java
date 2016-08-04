package org.oss.qbit.hello.org.oss.util;

import io.advantageous.qbit.admin.ManagedServiceBuilder;
import io.advantageous.qbit.annotation.RequestMapping;

import java.io.IOException;

import static io.advantageous.qbit.admin.ManagedServiceBuilder.managedServiceBuilder;

/**
 * Created by arang on 4/08/2016.
 */
public class QbitApplication
{
    public static void run(Class<?> clzzz,String args[])
    {
        System.out.println(clzzz.getPackage().getName());

        final ManagedServiceBuilder managedServiceBuilder =
                managedServiceBuilder()
                        .setRootURI("/api").setPort(8080);

        managedServiceBuilder.getContextMetaBuilder().setTitle("my-app");

        try {
            Class[] clazzes =  ClassesScanner.getClasses(clzzz.getPackage().getName());
            for(Class<?> clz : clazzes)
            {
                if (clz.isAnnotationPresent(RequestMapping.class))
                {

                    Object o = clz.newInstance();

                     /* Start the service. */

                    managedServiceBuilder.addEndpointService(o);

                }
            }
            managedServiceBuilder.getEndpointServerBuilder()
                    .build().startServer();
            managedServiceBuilder.enableLoggingMappedDiagnosticContext();

              /* Start the admin builder which exposes health end-points and meta data. */
            managedServiceBuilder.getAdminBuilder().build().startServer();

            System.out.println("Servers started");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
