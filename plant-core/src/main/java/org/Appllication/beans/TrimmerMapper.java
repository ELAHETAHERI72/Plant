package org.Appllication.beans;

import org.springframework.stereotype.Component;

@Component
public class TrimmerMapper {
   public String trimText(String text) {
        if (text != null && !text.isEmpty()) {
            return text.trim();
        }
        return null;
    }

}
