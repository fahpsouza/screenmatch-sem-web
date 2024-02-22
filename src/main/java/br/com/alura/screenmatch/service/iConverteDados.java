package br.com.alura.screenmatch.service;

public interface iConverteDados {
    <T> T obterdados (String json, Class<T> classe);
}
