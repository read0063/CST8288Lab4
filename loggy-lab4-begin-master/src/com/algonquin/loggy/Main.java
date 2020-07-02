package com.algonquin.loggy;

public class Main {

    public static void main(String[] args) {

        try {
            // Mock-up logs with non-supported content type
            mockLog(new Log(LogType.IMAGE,"first log", "Monday May 3, I had to wake up early"), new ImageFile("image.tif", "TIF", "******", Long.valueOf(1024)));//TODO why is TIF attaching?
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
        }

        try {
            // Mock-up logs with incorrect attachment
            mockLog(new Log(LogType.TEXT, "And even later, I need to have lunch"), new TextFile("eating.png", "PNG", "******", Long.valueOf(1024)));//TODO why are pngs attaching to TEXT logs?
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
        }

        try {
            // Mock-up logs with correct attachment
            mockLog(new Log(LogType.IMAGE,"first log", "Monday May 4, I had to wake up early"), new ImageFile("image.png", "PNG", "******", Long.valueOf(1024)));//TODO I lost the post processing
            mockLog(new Log(LogType.IMAGE,"Second log", "Few minutes later, I had my first cup of coffee"), new ImageFile("coffee.png", "PNG", "******", Long.valueOf(1024)));//TODO I lost the post processing
            mockLog(new Log(LogType.VIDEO,"third log", "Few minutes later, I am going for a ride"), new VideoFile("biking1.mp4", "MP4", "******", Long.valueOf(1024)));//TODO I lost the post processing
            mockLog(new Log(LogType.TEXT, "fourth log", "And even later, I need to have lunch"), new TextFile("recipie.txt", "TXT", "******", Long.valueOf(1024)));//TODO I lost the post processing
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage() + "\n\n");
//            e.printStackTrace();
        }

    }

    private static void mockLog(Log log, File file) throws Exception {
        System.out.println(">>> New log (" + log.toString() + ")");
        log.setAttachment(file);
        log.create();
        System.out.println("\n");
    }
}
