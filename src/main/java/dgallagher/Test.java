package dgallagher;

import com.fasterxml.jackson.databind.ObjectMapper;
import dgallagher.decode.*;
import dgallagher.requests.AvailRequest;
import dgallagher.requests.IRequest;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Test {

    public static void main(final String[] args){
        ObjectMapper mapper = new ObjectMapper();
        final IRequest ar = new AvailRequest();
        ((AvailRequest)ar).setType("Declan");
        Stream.of(new NameDecode(), new TypeDecode()).forEachOrdered(val -> System.out.println(val.apply(ar)));
        try {
            System.out.println(mapper.writeValueAsString(ar));
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        // Payload
        final PayLoad pl = new PayLoad();
        final IRequest rq = new AvailRequest();
        ((AvailRequest)rq).setName("declan");
        ((AvailRequest)rq).setType("mytype");
        pl.setRequest(rq);
        try {
            System.out.println(mapper.writeValueAsString(pl));
        } catch(Exception ex){
            System.out.println(ex.toString());
        }
        // use reflection to list all classes to use
        //Class<?> clazz = Class.forName(className.get());
        // PaymentMethod method = (PaymentMethod) clazz.newInstance();
        final DecodeConsumer dc = new DecodeConsumer();
        Stream.of(new NameDecodeSet(), new TypeDecodeSet()).forEachOrdered(fn -> dc.accept(fn, pl));
        try {
            System.out.println(mapper.writeValueAsString(pl));
        } catch(Exception ex){
            System.out.println(ex.toString());
        }

        Stream.of("A","B").forEachOrdered(String::toUpperCase);
    }

    /*private static Function<String, List<String>> getClasses = (a) -> {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        assert classLoader != null;
        String path = a.replace('.', '/');
        Enumeration<URL> resources = classLoader.getResources(path);
        List<File> dirs = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirs.add(new File(resource.getFile()));
        }
        ArrayList classes = new ArrayList();
        for (File directory : dirs) {
            classes.addAll(findClasses(directory, a));
        }
        return classes.toArray(new Class[0]);
    };*/

    private static List findClasses(File directory, String packageName) throws ClassNotFoundException {
        List classes = new ArrayList();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }
        return classes;
    }

    private static Function createJson = (a) -> {return new Object();};
}
