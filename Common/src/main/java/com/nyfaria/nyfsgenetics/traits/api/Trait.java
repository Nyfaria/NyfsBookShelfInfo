package com.nyfaria.nyfsgenetics.traits.api;

public interface Trait {
    Type getType();

    enum Type {
        DOMINANT("DD"),
        CODOMINANT("Dd"),
        RECESSIVE("dd"),
        MUTATION("M");
        private final String allele;
        Type(String allele) {
            this.allele = allele;
        }

        public String getAllele() {
            return allele;
        }
    }

}
