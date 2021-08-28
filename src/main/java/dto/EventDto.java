package dto;

import lombok.*;

@Builder
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    String title;
    String type;
    int breaks;
    int wage;
}
