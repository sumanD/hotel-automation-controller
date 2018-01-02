package com.sahaj.hms.domain.common;

import java.util.List;

/**
 * The {@link Floor} class represent a hotel floor.
 * <p>
 * A {@link Floor} entity consists of List of {@link MainCorridor} and {@link SubCorridor}
 * <p>
 * This class provides methods to operate on {@link MainCorridor} list and {@link SubCorridor} list of a {@link Floor}
 */
public class Floor {
    private List<MainCorridor> mainCorridors;
    private List<SubCorridor> subCorridors;
}
