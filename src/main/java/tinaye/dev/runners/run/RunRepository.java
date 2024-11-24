package tinaye.dev.runners.run;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
  private List<Run> runs = new ArrayList<>();

  List<Run> findAll() {
    return runs;
  }

  Optional<Run> findByID(Integer id){
    return runs.stream()
    .filter(run -> Objects.equals(run.id(), id))
    .findFirst();
  }

  void create(Run run)
  {
    runs.add(run);
  }

  @PostConstruct
  private void init(){
    runs.add(new Run(
      1,
      "Evening Jog",
      LocalDateTime.now(),
      LocalDateTime.now().plusMinutes(35),
      10,
      Location.OUTDOOR
    ));

    runs.add(new Run(
      2,
      "Morning Jog",
      LocalDateTime.now(),
      LocalDateTime.now().plusMinutes(80),
      65,
      Location.INDOOR
    ));
  }

}

