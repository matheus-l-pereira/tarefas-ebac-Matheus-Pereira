package br.com.mpereira.exceptions;

public class TipoChaveNaoEncontradaException extends Exception {

    private static final long serialVersionUID = -1389494673985257L;
    public TipoChaveNaoEncontradaException(String msg) {
        this(msg, null);
    }

    public TipoChaveNaoEncontradaException(String msg, Throwable e) {
        super(msg, e);
    }
}
