package com.sahaj.hms.domain.common;

import com.sahaj.hms.common.Builder;

import java.util.ArrayList;
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

    private Floor(List<MainCorridor> mainCorridors, List<SubCorridor> subCorridors) {
        this.mainCorridors = mainCorridors;
        this.subCorridors = subCorridors;
    }

    public List<MainCorridor> getMainCorridors() {
        return mainCorridors;
    }

    public List<SubCorridor> getSubCorridors() {
        return subCorridors;
    }

    public static class FloorBuilder implements Builder<Floor> {
        private List<MainCorridor> mainCorridors;
        private List<SubCorridor> subCorridors;

        public FloorBuilder(Integer numberOfMainCorridor, Integer numberOfSubCorridors) {
            mainCorridors = new ArrayList<>(numberOfMainCorridor);

            for (Integer i = 0; i < numberOfMainCorridor; i++) {
                MainCorridor mainCorridor = new MainCorridor.MainCorridorBuilder(i).construct();
                mainCorridors.add(mainCorridor);
            }

            subCorridors = new ArrayList<>(numberOfSubCorridors);
            for (Integer i = 0; i < numberOfSubCorridors; i++) {
                SubCorridor subCorridor = new SubCorridor.SubCorridorBuilder(i).construct();
                subCorridors.add(subCorridor);
            }
        }

        @Override
        public Floor construct() {
            return new Floor(this.mainCorridors, this.subCorridors);
        }

    }
}
