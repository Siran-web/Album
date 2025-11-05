package com.Album.Music.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ApiError {

    private String error;
    private LocalDateTime timestamp;
    private HttpStatus status;

    public ApiError() {this.timestamp = LocalDateTime.now();}

    public ApiError(String error ,  HttpStatus status) {
        this();
        this.error = error;
        this.status = status;
    }

}
