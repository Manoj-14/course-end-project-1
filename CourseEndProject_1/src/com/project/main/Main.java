package com.project.main;

import java.io.File;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.project.resources.classes.FileOperations;
import com.project.resources.classes.FoldersHandling;

public class Main {

	static Scanner input = new Scanner(System.in);
	static final String PATH = "D:\\Java FSD\\Course End Project 1\\CourseEndProject_1\\src\\com\\project\\resources\\data";
	static FoldersHandling foldersHandling = new FoldersHandling(PATH);

	public static void main(String[] args) {
		developerInfo();
		String op;
		boolean flag = true;
		while (flag) {
			System.out.println("--------------------------------------------------------");
			System.out.println("|                      Main Menu                       |");
			System.out.println("--------------------------------------------------------");
			System.out.println(
					"1. Fetch all files\n2. Do operations(Create, Delete, Search)\nOther option leads to exit\nEnter your option:");
			op = input.next();
			input.nextLine();
			switch (op) {
			case "1":
				fileList();
				break;
			case "2":
				operationOptions();
				break;
			default:
				System.out.println("------Thank You for using the Application------");
				System.exit(0);
			}
		}
	}

	private static void fileList() {
		try {
			List<File> files = foldersHandling.listAllFiles();
			if (files.size() > 0) {
				System.out
						.println("------Files in " + foldersHandling.getDirectory().getName() + " directory are------");
				for (File file : files)
					System.out.println(file.getName());
			} else {
				System.out.println("Folder is empty");
			}
		} catch (NullPointerException e) {
			System.out.print("Folder Not found");
		}
	}

	private static void operationOptions() {
		boolean flag = true;
		String filename, op;
		FileOperations fileOperations = new FileOperations(foldersHandling);
		while (flag) {
			System.out.println("--------------------------------------------------------");
			System.out.println("|                       Operations                     |");
			System.out.println("--------------------------------------------------------");
			System.out.println(
					"1. Create a file\n2. Delete a file\n3. Search a file\n4. Back to main menu\nEnter Your option(Any other digits to exit):");
			try {
				op = input.next();
				input.nextLine();
				switch (op) {
				case "1":
					System.out.print("Enter the file name to create: ");
					filename = input.nextLine();
					fileOperations.createFile(filename);
					break;
				case "2":
					System.out.print("Enter the file name to delete: ");
					filename = input.nextLine();
					fileOperations.deleteFile(filename);
					break;
				case "3":
					System.out.print("Enter the file name to search: ");
					filename = input.nextLine();
					if (fileOperations.searchFile(filename))
						System.out.println(filename + " found");
					else
						System.out.println(filename + " not found");
					break;
				case "4":
					flag = false;
					break;
				default:
					System.out.println("------Thank You for using the Application------");
					System.exit(0);
				}
			} catch (InputMismatchException ime) {
				System.out.println("Please enter the valid options");
			}
		}
	}

	private static void developerInfo() {
		System.out.println("--------------------------------------------------------");
		System.out.println("|                  Application name                    |");
		System.out.println("|                  Developer: Manoj M                  |");
	}
}
