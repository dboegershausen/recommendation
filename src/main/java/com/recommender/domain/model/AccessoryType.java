package com.recommender.domain.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AccessoryType {

    HELMET("Capacete") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return true;
        }
    },
    SIGNAL_LIGHTS("Luzes de Sinalização") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return true;
        }
    },
    SHORTS("Bermuda") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 5;
        }
    },
    WATER_BOTTLE("Garrafa d'Água") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 5;
        }
    },
    PORTABLE_PUMP("Bomba Portátil") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 10;
        }
    },
    SPATULA("Espátula")  {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 20;
        }
    },
    BACKUP_CHAMBER("Câmara Reserva") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 20;
        }
    },
    REPAIR_KIT("Kit de Reparos") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 40;
        }
    },
    OBJECT_HOLDER_SHIRT("Camisa Porta Objetos") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 40;
        }
    },
    FOOD("Alimentação") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 40;
        }
    },
    GLOVE("Luva") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 80;
        }
    },
    KEYS_KIT("Kit de Chaves") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 80;
        }
    },
    CHAIN_REPAIR("Reparo de Corrente") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 80;
        }
    },
    MECHANICS_KNOWLEDGE("Conhecimento em Mecânica") {
        @Override
        public boolean isIndicatedByDistance(Integer distance) {
            return distance > 80;
        }
    };


    private String name;

    AccessoryType(String name) {
        this.name = name;
    }

    public abstract boolean isIndicatedByDistance(Integer distance);

    public static List<AccessoryType> getIndicatedTypesByDistance(Integer distance) {
        return Arrays.asList(values()).stream()
                .filter(accessoryType -> accessoryType.isIndicatedByDistance(distance))
                .collect(Collectors.toList());
    }

}
