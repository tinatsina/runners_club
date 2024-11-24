package tinaye.dev.runners.run;

public class RunNotFoundException extends RuntimeException{
  public RunNotFoundException() {
    super("Run Not Found");
  }
}
