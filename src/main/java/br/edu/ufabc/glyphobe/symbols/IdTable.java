package br.edu.ufabc.glyphobe.symbols;

import java.util.HashMap;

import br.edu.ufabc.glyphobe.symbols.identifiers.AbstractIdentifier;

public class IdTable {
  private HashMap<String, AbstractIdentifier> symbols;

  public IdTable() {
    this.symbols = new HashMap<String, AbstractIdentifier>();
  }

  public AbstractIdentifier get(String key) {
    return this.symbols.get(key);
  }

  public void add(String key, AbstractIdentifier id) {
    this.symbols.put(key, id);
  }

  public boolean exists(String key) {
    return this.symbols.containsKey(key);
  }

  public HashMap<String, AbstractIdentifier> getSymbols() {
    return symbols;
  }

  public void setSymbols(HashMap<String, AbstractIdentifier> symbols) {
    this.symbols = symbols;
  }

  public AbstractIdentifier remove(String name) {
    return symbols.remove(name);
  }
}
