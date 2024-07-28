package org.example;

import java.io.File;

// Please keep these unchanged.
public class Constants {
    public static String projectDirectory = System.getProperty("user.dir") + File.separator + "output";
    public static String originalJdaDirectory = Main.class.getClassLoader().getResource("original").getPath();
    public static String basePackage = "org.jda.example.coursemanrestful";
}
