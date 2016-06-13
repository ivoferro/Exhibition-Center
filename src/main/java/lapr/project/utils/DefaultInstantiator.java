/**
 * Package location for Pure Fabrication util classes.
 */
package lapr.project.utils;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lapr.project.model.*;
import lapr.project.model.mechanisms.EquitableLoadMechanism;

/**
 * Util class to create instances to tests.
 *
 * @author Daniel Gonçalves 1151452
 * @author Eric Amaral 1141570
 * @author Ivo Ferro 1151159
 * @author Renato Oliveira 1140822
 * @author Ricardo Correia 1151231
 */
public class DefaultInstantiator {

    public static ExhibitionCenter createExhibitionCenter() {

        // GENERAL
        
        User userIvo = new User("Ivo Ferro", "ivoferro", "1151159@isep.ipp.pt", "123+Qwe");
        User userDaniel = new User("Daniel Gonçalves", "danielgoncalves", "1151452@isep.ipp.pt", "Qwe+123");
        User userEric = new User("Eric Amaral", "ericamaral", "1141570@isep.ipp.pt", "234+Wer");
        User userRenato = new User("Renato Oliveira", "renatooliveira", "1140822@isep.ipp.pt", "Wer+234");
        User userRicardo = new User("Ricardo Correia", "ricardocorreia", "1151231", "123-Asd");

        ExhibitionsManager exhibitionsManager = new ExhibitionsManager(userDaniel);

        Organizer organizerIvo = new Organizer(userIvo);
        Organizer organizerEric = new Organizer(userEric);
        Organizer organizerRenato = new Organizer(userRenato);
        Organizer organizerRicardo = new Organizer(userRicardo);

        StaffMember staffMemberIvo = new StaffMember(userIvo);
        StaffMember staffMemberEric = new StaffMember(userEric);
        StaffMember staffMemberRenato = new StaffMember(userRenato);
        StaffMember staffMemberRicardo = new StaffMember(userRicardo);

        Exhibitor exhibitorSonae = new Exhibitor("Sonae", "trades@sonae.com", "912345678");
        Exhibitor exhibitorBlip = new Exhibitor("Blip", "marketing@blip.pt", "918765432");
        Exhibitor exhibitorCritical = new Exhibitor("Critical Software", "main@critical.software.com", "931245678");
        
        User userBelmiro = new User("Belmiro Azevedo", "belmiroazevedo", "belmirazevedo@sonae.com", "321+Ewq");
        User userFabioSilva = new User("Fábio Silva", "fabiosilva", "fabiosilva@blip.pt", "Ewq+321");
        User userGoncaloQuadros = new User("Gonçalo Quadros", "gonacaloquadros", "goncaloquadros@critical.software.com", "432+Rew");
        
        ExhibitorResponsible exhibitorResponsibleSonae = new ExhibitorResponsible(userBelmiro);
        ExhibitorResponsible exhibitorResponsibleblip = new ExhibitorResponsible(userFabioSilva);
        ExhibitorResponsible exhibitorResponsibleCritical = new ExhibitorResponsible(userGoncaloQuadros);
        
        Product product1 = new Product("Projetor");
        Product product2 = new Product("Table");
        Product product3 = new Product("PC");
        Product product4 = new Product("Tale");
        Product product5 = new Product("MacBook");

        Resource resource1 = new Resource("Water");
        Resource resource2 = new Resource("Electricity");
        Resource resource3 = new Resource("Gunpowder");
        Resource resource4 = new Resource("Wood");
        Resource resource5 = new Resource("Iron");
        
        Stand stand1 = new Stand(44.4f);
        Stand stand2 = new Stand(124.3f);
        Stand stand3 = new Stand(33f);
        Stand stand4 = new Stand(320.5f);
        Stand stand5 = new Stand(30f);
        
        StaffAttributionMechanism staffAttributionMechanism1 = new EquitableLoadMechanism();
        
        
        // Exhibition computer science
        
        List<Organizer> organizersComputerScience = new ArrayList<>();
        organizersComputerScience.add(organizerIvo);
        organizersComputerScience.add(organizerEric);
        OrganizersList organizersListComputerScience = new OrganizersList(organizersComputerScience);
        
        List<StaffMember> staffMembersComputerScience = new ArrayList<>();
        staffMembersComputerScience.add(staffMemberRenato);
        staffMembersComputerScience.add(staffMemberRicardo);
        StaffList staffListComputerScience = new StaffList(staffMembersComputerScience);
        
        Place placeComputerScience = new Place("H301");
        
        Exhibition exhibitionComputerScience = new Exhibition("Computer Science", "Conferences about computer science.",
                new Date(2015, 7, 23), new Date(2015, 8, 11), new Date(2015, 6, 15),
                new Date(2015, 7, 5), new Date(2015, 7, 8), new Date(2015, 7, 15),
                placeComputerScience, staffListComputerScience, organizersListComputerScience,
                new ApplicationsList(), new DemonstrationsList(), new StaffAttributionsList());
        
        
        // Applications computer science
        
        List<Product> productListNodeJs = new ArrayList<>();
        productListNodeJs.add(product1);
        productListNodeJs.add(product2);
        
        ExhibitionApplication exhibitionApplicationNodeJs = new ExhibitionApplication("Node JS", exhibitorBlip, 105.3f, 
                30, productListNodeJs, new ArrayList<>(), 
                new ArrayList<>(), new ArrayList<>());
        
        
        // Applications computer science - Evaluations Node JS
        
        List<Integer> answerListNodeJs1 = new ArrayList<>();
        answerListNodeJs1.add(3);
        answerListNodeJs1.add(4);
        answerListNodeJs1.add(5);
        answerListNodeJs1.add(1);
        answerListNodeJs1.add(3);
        StaffAttribution staffAttributionNodeJs1 = new StaffAttribution(exhibitionApplicationNodeJs, staffMemberRenato);
        Evaluation evaluationNodeJs1 = new Evaluation(answerListNodeJs1, staffAttributionNodeJs1);
        
        List<Integer> answerListNodeJs2 = new ArrayList<>();
        answerListNodeJs2.add(2);
        answerListNodeJs2.add(3);
        answerListNodeJs2.add(4);
        answerListNodeJs2.add(2);
        answerListNodeJs2.add(2);
        StaffAttribution staffAttributionNodeJs2 = new StaffAttribution(exhibitionApplicationNodeJs, staffMemberRicardo);
        Evaluation evaluationNodeJs2 = new Evaluation(answerListNodeJs2, staffAttributionNodeJs2);
        
        List<Evaluation> evaluationsNodeJs = new ArrayList<>();
        evaluationsNodeJs.add(evaluationNodeJs1);
        evaluationsNodeJs.add(evaluationNodeJs2);

        exhibitionApplicationNodeJs.setEvaluationsList(evaluationsNodeJs);
        
        
        // Demonstrations for computer science
        
        Demonstration demonstrationAngularJs = new Demonstration("Angular JS", "Get started with angular js.", 
                placeComputerScience, staffListComputerScience, organizersListComputerScience, 
                new ApplicationsList(), new ArrayList<>(), new StaffAttributionsList());
        
        
        // Applications for demonstartion angular js
        
        List<KeyWord> keyWordsAngluarJs = new VirtualFlow.ArrayLinkedList<>();
        keyWordsAngluarJs.add(new KeyWord("AngularJS"));
        keyWordsAngluarJs.add(new KeyWord("UpAndReady"));
        keyWordsAngluarJs.add(new KeyWord("GetStarted"));
        keyWordsAngluarJs.add(new KeyWord("WEB"));
        keyWordsAngluarJs.add(new KeyWord("Development"));
        
        List<Product> productsAngularJs = new ArrayList<>();
        productsAngularJs.add(product1);
        productsAngularJs.add(product3);
        
        DemonstrationApplication demonstrationApplicationAngularJs = new DemonstrationApplication("Angular JS", keyWordsAngluarJs, 
                exhibitorSonae, 45.5f, 20, 
                productsAngularJs, new ArrayList<>());
        
        List<Integer> answerListAngularJs1 = new ArrayList<>();
        answerListNodeJs1.add(5);
        answerListNodeJs1.add(4);
        answerListNodeJs1.add(5);
        answerListNodeJs1.add(3);
        answerListNodeJs1.add(4);
        StaffAttribution staffAttributionAngularJs1 = new StaffAttribution(demonstrationApplicationAngularJs, staffMemberRenato);
        Evaluation evaluationAngularJs1 = new Evaluation(answerListAngularJs1, staffAttributionAngularJs1);
        
        List<Evaluation> evaluationsAngularJs = new ArrayList<>();
        evaluationsAngularJs.add(evaluationAngularJs1);
        
        demonstrationApplicationAngularJs.setEvaluationsList(evaluationsAngularJs);
        
        List<Application> applicationsAngularJs = new ArrayList<>();
        applicationsAngularJs.add(demonstrationApplicationAngularJs);
        ApplicationsList applicationsListAngularJs = new ApplicationsList(applicationsAngularJs);
        
        // Demos to expo
        
        List<Demonstration> demonstrationsList = new ArrayList<>();
        demonstrationsList.add(demonstrationAngularJs);
        DemonstrationsList demonstrationsListComputerScience = new DemonstrationsList(demonstrationsList);
        
        exhibitionComputerScience.setDemonstrationsList(demonstrationsListComputerScience);
        
        // Exhibition Center
        
        // TODO modify this
        
        List<Exhibition> exhibitions = new ArrayList<>();
        exhibitions.add(exhibitionComputerScience);
        ExhibitionsRegister exhibitionsRegister = new ExhibitionsRegister(exhibitions);
        
        List<User> users = new ArrayList<>();
        users.add(userIvo);
        users.add(userDaniel);
        users.add(userEric);
        users.add(userRenato);
        users.add(userRicardo);
        users.add(userBelmiro);
        users.add(userFabioSilva);
        users.add(userGoncaloQuadros);
        UsersRegister usersRegister = new UsersRegister(users);
        
        List<Resource> resources = new ArrayList<>();
        resources.add(resource1);
        resources.add(resource2);
        resources.add(resource3);
        resources.add(resource4);
        resources.add(resource5);
        ResourcesRegister resourcesRegister = new ResourcesRegister(resources);
        
        List<Stand> stands = new ArrayList<>();
        stands.add(stand1);
        stands.add(stand2);
        stands.add(stand3);
        stands.add(stand4);
        stands.add(stand5);
        StandsRegister standsRegister = new StandsRegister(stands);
        
        List<StaffAttributionMechanism> staffAttributionMechanisms = new ArrayList<>();
        staffAttributionMechanisms.add(staffAttributionMechanism1);
        MechanismsRegister mechanismsRegister = new MechanismsRegister(staffAttributionMechanisms);
        
        ExhibitionCenter exhibitionCenter = new ExhibitionCenter(exhibitionsRegister, usersRegister, 
                resourcesRegister, standsRegister, mechanismsRegister);
        
        return exhibitionCenter;
    }
}
