package com.bookstore.jpa.dtos;

import java.util.Set;
import java.util.UUID;

public record BookRecordDtos(String title, UUID publisher_id, Set<UUID> authorIds, String reviewComent) {

}
