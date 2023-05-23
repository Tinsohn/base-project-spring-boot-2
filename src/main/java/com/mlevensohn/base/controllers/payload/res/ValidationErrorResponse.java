package com.mlevensohn.base.controllers.payload.res;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ValidationErrorResponse {
    private List<String> errors;
    private List<String> fieldErrors;
}
