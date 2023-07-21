import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class server {
  public static void main(String[] args) throws Exception {
    HttpServer servers = HttpServer.create(new InetSocketAddress(8080), 0);
    servers.createContext("/", new RootHandler());
    servers.setExecutor(null);
    servers.start();
    System.out.println("Server iniciado");
    /*ServerSocket serverSocket = new ServerSocket(8080);
    while(true) {
      Socket node = serverSocket.accept();
      System.out.println("Chegou uma conexão, criando thread..");
      answerThread at = new answerThread(node);
      at.start();
    }*/
  }
}

class RootHandler implements HttpHandler {
  @Override
  public void handle(HttpExchange he) throws IOException{
    String response = "<h1>Server start success if you see this message</h1>" + "<h1>Port: " + 8080 + "</h1>";
    he.sendResponseHeaders(200, response.length());
    he.getResponseHeaders().add("Access-Control-Allow-Origin", "127.0.0.1:550");
    he.getResponseHeaders().add("Access-Control-Allow-Origin", "http://localhost:8080");
    OutputStream os = he.getResponseBody();
    os.write(response.getBytes());
    os.close();
    System.out.println("Requisição respondida");
  }
}

class answerThread extends Thread {
  private Socket node;

  public answerThread(Socket node) {
    this.node = node;
  }

  public void run() {
    try {
      DataInputStream dis = new DataInputStream(node.getInputStream());

      DataOutputStream dos = new DataOutputStream(node.getOutputStream());
      dos.writeChars("HTTP/1.1 200 OK\nContent-Type: text/plain\nContent-Length: 12\n\nHello world!");
      System.out.println("Mandei oi");
      node.close();
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}