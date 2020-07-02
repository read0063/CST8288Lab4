package com.algonquin.loggy;

import java.util.*;

public class Log {

    private String name;
    private String description;
    private Date date;
    private UUID uuid;
    private String code;
    private File attachment;
    private LogType logType;//Moira added type to the attributes of a Log


    public File getAttachment() {
        return attachment;
    }

    public void setAttachment(File attachment) throws Exception {
        //Moira call the Attachable method attachFile from File to set
        if(attachment.isValidContentType(attachment.getType())){
            System.out.println("Attaching " + attachment.getName() + " to " + this.getName());
            this.attachment = attachment;
            attachment.postProcess();
        } else {
            System.out.println("ContentType " + attachment.getType() + " can not be attached");
            throw new Exception("ContentType " + attachment.getType() + " can not be attached");
        }

    }

    public void create() {
        System.out.println("Log record for " + uuid + " has been created");
    }

    public void read() {
        System.out.println("Log " + uuid + " name:" + name + ", description: " + description + " created on " + date);
    }

    public void update(String name, String description) {
        System.out.println("Log record for " + uuid + " has been updated");
        this.name = name;
        this.description = description;
    }

    public void delete() {
        System.out.println("Log record for " + uuid + " has been deleted");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Log() {
        this.name = null;
        this.description = null;
        this.date = null;
        this.uuid = null;
        this.code = null;
        this.logType = null;//Moira added type to the log attributes
    }

    public Log(LogType logType, String name) {
        this(logType, name, "", new Date());//Moira default LogType is text
    }

    public Log(LogType logType, String name, String description) {
        this(logType, name, description, new Date());
    }

    public Log(LogType logType, String name, String description, Date date) {
        this.logType = logType;
        this.name = name;
        this.description = description;
        this.date = date;
        this.uuid = UUID.randomUUID();
        this.code = shortCode();
    }

    public String toString() {
        String out = code + ":" + name + ":" + description + ":" + date;
        if (this.attachment != null) {
            out += " with attachment " + this.attachment.getName();
        }
        return out;
    }

    private String shortCode() {
        return randomChars(3) + "-" + randomChars(3) + "-" + randomChars(3);
    }

    private String randomChars(int n) {
        String randomchars = "";
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        Random rnd = new Random();
        for (int i = 0; i < n; i++) {
            randomchars += chars.charAt(rnd.nextInt(chars.length()));
        }
        return randomchars;
    }
}
