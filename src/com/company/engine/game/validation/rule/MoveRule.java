package com.company.engine.game.validation.rule;

import com.company.commons.move.PlaneMove;

import java.util.function.Predicate;

public interface MoveRule extends Predicate<PlaneMove> {}
