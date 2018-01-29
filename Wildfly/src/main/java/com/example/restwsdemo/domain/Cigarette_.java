package com.example.restwsdemo.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cigarette.class)
public class Cigarette_ {
	public static volatile SingularAttribute<Cigarette, Integer> id;
	public static volatile SingularAttribute<Cigarette, String> name;
	public static volatile SingularAttribute<Cigarette, Double> price;
	public static volatile SingularAttribute<Cigarette, Integer> count;
}

