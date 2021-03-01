package com.company.ui.console;

import com.company.commons.move.PlaneMove;

public interface StringToMoveMapper {

    PlaneMove map(String move);
}
