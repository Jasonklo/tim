package com.infosys.timetracker.tim.exception;

public class TaskNotFoundException extends RuntimeException{

               public TaskNotFoundException(Character id) {
                    super("Could not find employee" + id);
                }
}
