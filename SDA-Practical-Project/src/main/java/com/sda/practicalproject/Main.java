package com.sda.practicalproject;

import com.sda.practicalproject.model.Vet;
import com.sda.practicalproject.repository.VetRepository;
import com.sda.practicalproject.repository.VetRepositoryImpl;
import com.sda.practicalproject.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject.utils.SessionManager;
import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) throws EntityUpdateFailedException {
        SessionManager.getSessionFactory();

        VetRepository vetRepository = new VetRepositoryImpl();
        Vet veterinarulTiti = new Vet(
                "Titi",
        "Aur",
        "Str.Vitezei nr 10",
        "Pisici",
        );
        vetRepository.save(veterinarulTiti);

        System.out.println(vetRepository.findById(1L));
        System.out.println(vetRepository.findAll());
        veterinarulTiti.setFirstName("TitiUpdatat");
        vetRepository.update(veterinarulTiti);
        System.out.println(vetRepository.findById(1l));

        vetRepository.delete(veterinarulTiti);
        System.out.println(vetRepository.findById(1l));







        SessionManager.shutdown();
    }
}
