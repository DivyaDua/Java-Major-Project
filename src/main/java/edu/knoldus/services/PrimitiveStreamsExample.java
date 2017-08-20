package edu.knoldus.services;

import org.apache.commons.lang3.ObjectUtils;

import java.util.stream.IntStream;

public class PrimitiveStreamsExample {

    double average(IntStream intStream){
        return intStream.average().orElse(0.0);
    }

    IntStream generateStream(int a){
        return IntStream.empty();
    }


}
