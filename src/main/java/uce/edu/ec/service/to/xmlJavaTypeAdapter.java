package uce.edu.ec.service.to;

import uce.edu.ec.repository.modelo.LocalDateTimeAdapter;

public @interface xmlJavaTypeAdapter {

    Class<LocalDateTimeAdapter> value();

}
