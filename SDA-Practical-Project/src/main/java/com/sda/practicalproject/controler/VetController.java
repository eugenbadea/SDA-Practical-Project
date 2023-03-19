package com.sda.practicalproject.controler;

import com.sda.practicalproject.model.Vet;
import com.sda.practicalproject.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject.service.VetService;
import com.sda.practicalproject.service.exception.EntityNotFoundException;

import java.util.Scanner;

public class VetController {
    private final VetService vetService;
    private final Scanner scanner;

    public VetController(VetService vetService, Scanner scanner) {
        this.vetService = vetService;
        this.scanner = scanner;
    }

    public void createVet() {
        try {
            System.out.println("Please inert the vet's first name:");
            String firstName = scanner.nextLine();
            System.out.println("Please inert the vet's last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please inert the vet's address:");
            String address = scanner.nextLine();
            System.out.println("Please inert the vet's speciality:");
            String speciality = scanner.nextLine();

            vetService.addVet(firstName, lastName, address, speciality);
            System.out.println("Vet's details successfully saved");
        } catch (IllegalArgumentException e) {

            System.err.println(e.getMessage());
        } catch (EntityUpdateFailedException e) {
            System.err.println(e.getMessage());
            System.err.println("Please retry!");
        } catch (Exception e) {
            System.err.println("Internal server error");
        }
    }

    public void displayAllVets() {
        for (Vet vet : vetService.getAllVets()) {
            System.out.println(vet.getId() + " " + vet.getFirstName() + " " + vet.getLastName());
        }

    }

    public void updateVet() {
        try {
            System.out.println("Please enter the vet's id");
            long id = Long.parseLong(scanner.nextLine());
            System.out.println("Please enter the vet's last name:");
            String lastName = scanner.nextLine();
            System.out.println("Please enter the vet's address:");
            String address = scanner.nextLine();
            System.out.println("Please enter the vet's speciality:");
            String speciality = scanner.nextLine();

            vetService.updateVet(id, lastName, address, speciality);
            System.out.println("Vet has been updated");


        } catch (NumberFormatException e) {
            System.err.println("Please insert valid numeric id");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            System.out.println("Please retry");
        } catch (EntityNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Internal server error");
        }

    }
}
