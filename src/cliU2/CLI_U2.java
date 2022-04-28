package cliU2;

import logc.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

/**
 * cli command  create a producer  , data media ; deleted data media
 *
 */
public class CLI_U2 {


    public static void main(String[] args) throws Exception {

        AtomicBoolean running = new AtomicBoolean();
        G_logik g_logik = new G_logik();
        Darstellung_logic darstellung_logic = new Darstellung_logic();
        UploaderImpl uploader = new UploaderImpl();
        InteractiveVideoImpl interactiveVideo = new InteractiveVideoImpl();
        LicensedAudioImpl licensedAudio = new LicensedAudioImpl();
        LicensedVideoImpl licensedVideo = new LicensedVideoImpl();
        LicensedAudioVideoImpl licensedAudioVideo = new LicensedAudioVideoImpl();
        Object items = null;
        welcome();
        running.set(true);
        while (running.get()) {

            ArrayList<String> commands = new ArrayList<>();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String test = bufferedReader.readLine();
            String[] words = test.split(" ");

            Arrays.stream(words).map(x -> commands.add(x)).collect(Collectors.toList());


            switch (commands.get(0)) {
                case "create":

                    switch (commands.get(1)) {
                        case "-p":
                            uploader.setName(commands.get(2) + commands.get(3));
                            g_logik.createProduzenten(uploader);
                            System.out.println("producer was create Name:" + commands.get(2) + ",Lastname:" + commands.get(3));
                            break;

                        case "-d":
                            switch (commands.get(2)) {
                                case "iv":
                                    items = interactiveVideo;
                                    System.out.println("create interactive video");
                                    break;
                                case "lv":
                                    items = licensedVideo;
                                    System.out.println("create a licensed video");
                                    break;
                                case "la":
                                    items = licensedAudio;
                                    System.out.println("create a licensed audio");
                                    break;
                                case "lav":
                                    items = licensedAudioVideo;
                                    System.out.println("create a licensed audio video");
                                    break;
                            }

                            if (!darstellung_logic.getItemsList().isEmpty() && darstellung_logic.getItemsList().contains(items)) {

                                System.out.println("the data is already added , select other one");
                            } else
                                darstellung_logic.addItems(items);

                    }
                    break;

                case "delete":
                    if (!darstellung_logic.getItemsList().isEmpty() && darstellung_logic.getItemsList().contains(items)) {
                        switch (commands.get(1)) {
                            case "iv":
                                darstellung_logic.removeItems(interactiveVideo);
                                System.out.println(" interactive video was deled");
                                break;
                            case "lv":
                                darstellung_logic.removeItems(licensedVideo);
                                System.out.println("licensed video was deleted");
                                break;
                            case "la":
                                darstellung_logic.removeItems(licensedAudio);
                                System.out.println("licensed audio was deleted");
                                break;
                            case "lav":
                                darstellung_logic.removeItems(licensedAudioVideo);
                                System.out.println("licensed audio video was deleted");
                                break;
                        }


                    }else
                        System.out.println("the data is not added");

                    break;
                case "help":
                    info();
                    break;
                case "show":
                    darstellung_logic.getItemsList().stream().forEach(x -> System.out.println(x));
                    break;
                case "exit":
                    System.out.println("Done");
                    running.set(false);
                    break;
                default:
                    throw new IllegalArgumentException("not command recognized ");
            }
        }

    }


    /**
     * String to helping the start from the user
     */
    public static void welcome() {

        System.out.println("Hallo " + System.getProperty("user.name"));
        System.out.println("What would you like to do today");
        System.out.println("you can create a producer or data media and you can also delete");
        System.out.println("type help from more information");

    }

    /**
     * explanation how command has to be use.
     */
    public static void info() {

        System.out.println("                          HELP                               ");
        System.out.println("-------------------------------------------------------------");
        System.out.println("create:      -d  -p    create a new producer o data media ");
        System.out.println("deleted:             delete a data media ");
        System.out.println("Examples:  create -p exampleName exampleLastname ");
        System.out.println("exit         for to  finish the program");
        System.out.println("show:        the list from items");
        System.out.println("Examples:   create -d iv -> interactive video ");
        System.out.println("Examples:   create -d lv -> licensed video ");
        System.out.println("Examples:   create -d la -> licensed audio ");
        System.out.println("Examples:   delete  lav -> licensed audio video ");
        System.out.println("-------------------------------------------------------------");


    }
}
