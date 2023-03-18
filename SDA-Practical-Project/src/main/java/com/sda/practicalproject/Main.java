package com.sda.practicalproject;

import com.sda.practicalproject.model.Vet;
import com.sda.practicalproject.repository.VetRepository;
import com.sda.practicalproject.repository.VetRepositoryImpl;
import com.sda.practicalproject.repository.exception.EntityUpdateFailedException;
import com.sda.practicalproject.utils.SessionManager;
import jdk.swing.interop.SwingInterOpUtils;

public class Main {
    public static void main(String[] args) throws EntityUpdateFailedException {
     



        SessionManager.shutdown();
    }
}
