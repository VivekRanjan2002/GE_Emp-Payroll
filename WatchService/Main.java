package org.bridgeLabz.WatchService;

import java.nio.file.*;
import java.util.*;

public class Main {
    @SuppressWarnings("ReassignedVariable")
    public static void main(String[] args) {

         try(WatchService service= FileSystems.getDefault().newWatchService()){ // new instance of watchservice class
             Map<WatchKey, Path> KeyMap= new HashMap<>();
             //Path Objects pointing to my files directory where watch operations like create,del,updt
             Path path=  Paths.get("src/main/java/org/bridgeLabz/WatchService");
            //Populating the KeyMap with event kinds and path objects
             KeyMap.put(path.register(service,
                     StandardWatchEventKinds.ENTRY_CREATE,
                     StandardWatchEventKinds.ENTRY_DELETE,
                     StandardWatchEventKinds.ENTRY_MODIFY),path);

             //Creating instance of watch Key
             WatchKey watchKey;
             do{
                 watchKey= service.take();
                 Path eventDir=KeyMap.get(watchKey);
                 for(WatchEvent<?> event: watchKey.pollEvents()){
                     WatchEvent.Kind<?> kind= event.kind();
                     Path eventPath= (Path)event.context();
                     System.out.println(eventDir+": "+event+": "+eventPath);
                 }
             }
             while(watchKey.reset());

         }
         catch (Exception e){
             System.out.println(e);
         }
    }
}
