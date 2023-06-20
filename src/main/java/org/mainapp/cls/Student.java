package org.mainapp.cls;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
    private String name;
    private String gender;
    private int dob;
    private String pob;
    private String ethnicity;
    private String region;
    private String idtype;
    private String id;
    private String politicalstatus;
}
