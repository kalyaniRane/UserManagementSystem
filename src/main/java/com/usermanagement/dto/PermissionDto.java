package com.usermanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PermissionDto {

    private boolean dashboardAdd;
    private boolean dashboardDelete;
    private boolean dashboardModify;
    private boolean dashboardRead;
    private boolean settingsAdd;
    private boolean settingsDelete;
    private boolean settingsModify;
    private boolean settingsRead;
    private boolean userInformationAdd;
    private boolean userInformationDelete;
    private boolean userInformationModify;
    private boolean userInformationRead;
    private boolean webpage1Add;
    private boolean webpage1Delete;
    private boolean webpage1Modify;
    private boolean webpage1Read;
    private boolean webpage2Add;
    private boolean webpage2Delete;
    private boolean webpage2Modify;
    private boolean webpage2Read;
    private boolean webpage3Add;
    private boolean webpage3Delete;
    private boolean webpage3Modify;
    private boolean webpage3Read;

}
