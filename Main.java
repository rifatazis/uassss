package com.example.uas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;

public class Main extends Application {
    private String startNode;
    private String endNode;
    private Stage window;
    private Scene scene1, scene2;
    private TextArea result;
    private TextField fromTf, toTf;
    private Map<String, Map<String, Integer>> graph;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        window = stage;
        initGraph();
        initUI();

        window.setScene(scene1);
        window.setTitle("Maps");
        window.show();
    }

    private void initGraph() {
        List<String> nodes = new ArrayList<>();
        nodes.add("ASRAMA PUTRA");
        nodes.add("ASRAMA PUTRI");
        nodes.add("PKM");
        nodes.add("PERPUSTAKAAN");
        nodes.add("REKTORAT");
        nodes.add("IC");
        nodes.add("MASJID AL-JAMIAH");
        nodes.add("GB F DAKWAH");
        nodes.add("FEKON");
        nodes.add("GEDUNG BARU");
        nodes.add("LABOR FASTE");
        nodes.add("FAK. SAINTEK K");
        nodes.add("FASTE DAN TARBIYAH L");
        nodes.add("FAK. DAKWAH D");
        nodes.add("FAK. PSIKOLOGI C");
        nodes.add("FAK. USHU");
        nodes.add("FAK USHU & FAPERTAPET G");
        nodes.add("FAK. SYARIAH & HUKUM");
        nodes.add("FAK. TARBIYAH I");
        nodes.add("FAK. TARBIYAH ONM");
        nodes.add("LAP. BASKET");
        nodes.add("FAPERTAPET E");
        nodes.add("FAPERTAPET F");
        nodes.add("DEKANAT FAK. TARBIYAH");
        nodes.add("JL BULUH CINA");
        nodes.add("JL A");
        nodes.add("JL B");
        nodes.add("JL C");
        nodes.add("JL D");
        nodes.add("JL E");
        nodes.add("JL F");
        nodes.add("JL G");
        nodes.add("JL H");
        nodes.add("JL I");
        nodes.add("JL J");
        nodes.add("JL K");
        nodes.add("JL BULUH CINA");

        graph = new HashMap<>();

        graph.put("ASRAMA PUTRA", new HashMap<>());
        graph.get("ASRAMA PUTRA").put("JL J", 1);

        graph.put("ASRAMA PUTRI", new HashMap<>());
        graph.get("ASRAMA PUTRI").put("JL H", 1);

        graph.put("PKM", new HashMap<>());
        graph.get("PKM").put("JL B", 1);

        graph.put("IC", new HashMap<>());
        graph.get("IC").put("JL B", 1);

        graph.put("PERPUSTAKAAN", new HashMap<>());
        graph.get("PERPUSTAKAAN").put("JL B", 1);

        graph.put("REKTORAT", new HashMap<>());
        graph.get("REKTORAT").put("JL C", 1);

        graph.put("FEKON", new HashMap<>());
        graph.get("FEKON").put("JL D", 1);

        graph.put("GEDUNG BARU", new HashMap<>());
        graph.get("GEDUNG BARU").put("JL K",1);

        graph.put("FAK. PSIKOLOGI C", new HashMap<>());
        graph.get("FAK. PSIKOLOGI C").put("JL D", 1);

        graph.put("GB F DAKWAH", new HashMap<>());
        graph.get("GB F DAKWAH").put("JL D", 1);

        graph.put("FAK. DAKWAH D", new HashMap<>());
        graph.get("FAK. DAKWAH D").put("JL D", 1);

        graph.put("MASJID AL-JAMIAH", new HashMap<>());
        graph.get("MASJID AL-JAMIAH").put("JL A", 1);
        graph.get("MASJID AL-JAMIAH").put("JL B", 1);

        graph.put("LABOR FASTE", new HashMap<>());
        graph.get("LABOR FASTE").put("JL I", 1);

        graph.put("FAK. SAINTEK K", new HashMap<>());
        graph.get("FAK. SAINTEK K").put("JL I", 1);

        graph.put("FASTE DAN TARBIYAH L", new HashMap<>());
        graph.get("FASTE DAN TARBIYAH L").put("JL G", 1);

        graph.put("DEKANAT FAK. TARBIYAH", new HashMap<>());
        graph.get("DEKANAT FAK. TARBIYAH").put("JL E", 1);

        graph.put("FAK. TARBIYAH I", new HashMap<>());
        graph.get("FAK. TARBIYAH I").put("JL E", 1);

        graph.put("FAK. SYARIAH & HUKUM", new HashMap<>());
        graph.get("FAK. SYARIAH & HUKUM").put("JL A", 1);

        graph.put("LAP. BASKET", new HashMap<>());
        graph.get("LAP. BASKET").put("JL E", 1);

        graph.put("FAK. USHU", new HashMap<>());
        graph.get("FAK. USHU").put("JL F", 1);

        graph.put("FAPERTAPET E", new HashMap<>());
        graph.get("FAPERTAPET E").put("JL F", 1);

        graph.put("FAPERTAPET F", new HashMap<>());
        graph.get("FAPERTAPET F").put("JL H", 1);

        graph.put("FAK. USHU & FAPERTAPET G", new HashMap<>());
        graph.get("FAK. USHU & FAPERTAPET G").put("JL E", 1);

        graph.put("FAK. TARBIYAH ONM", new HashMap<>());
        graph.get("FAK. TARBIYAH ONM").put("JL G",1);

        graph.put("JL A", new HashMap<>());
        graph.get("JL A").put("MASJID AL-JAMIAH", 1);
        graph.get("JL A").put("FAK. SYARIAH & HUKUM", 1);
        graph.get("JL A").put("JL B", 1);
        graph.get("JL A").put("JL D", 1);
        graph.get("JL A").put("JL G", 1);
        graph.get("JL A").put("JL I", 1);
        graph.get("JL A").put("JL J", 1);
        graph.get("JL A").put("JL F", 1);
        graph.get("JL A").put("JL BULUH CINA", 100);

        graph.put("JL B", new HashMap<>());
        graph.get("JL B").put("PKM", 1);
        graph.get("JL B").put("IC", 1);
        graph.get("JL B").put("PERPUSTAKAAN", 1);
        graph.get("JL B").put("MASJID AL-JAMIAH",  1);
        graph.get("JL B").put("JL A",  1);
        graph.get("JL B").put("JL C",  1);
        graph.get("JL B").put("JL D",  1);

        graph.put("JL C", new HashMap<>());
        graph.get("JL C").put("REKTORAT", 1);
        graph.get("JL C").put("JL B", 1);
        graph.get("JL C").put("JL J", 1);

        graph.put("JL D", new HashMap<>());
        graph.get("JL D").put("FEKON", 1);
        graph.get("JL D").put("FAK. PSIKOLOGI C", 1);
        graph.get("JL D").put("GB F DAKWAH", 1);
        graph.get("JL D").put("FAK. DAKWAH D", 1);
        graph.get("JL D").put("JL A", 1);
        graph.get("JL D").put("JL B", 1);
        graph.get("JL D").put("JL E", 1);
        graph.get("JL D").put("JL F", 1);

        graph.put("JL E", new HashMap<>());
        graph.get("JL E").put("DEKANAT FAK. TARBIYAH", 1);
        graph.get("JL E").put("FAK. TARBIYAH I", 1);
        graph.get("JL E").put("LAP. BASKET", 1);
        graph.get("JL E").put("FAK. USHU & FAPERTAPET G", 1);
        graph.get("JL E").put("JL G", 1);
        graph.get("JL E").put("JL F", 1);

        graph.put("JL F", new HashMap<>());
        graph.get("JL F").put("FAPERTAPET E",1);
        graph.get("JL F").put("FAK. USHU",1);
        graph.get("JL F").put("JL E",1);
        graph.get("JL F").put("JL A",1);
        graph.get("JL F").put("JL D",1);

        graph.put("JL G", new HashMap<>());
        graph.get("JL G").put("FASTE DAN TARBIYAH L", 1);
        graph.get("JL G").put("FAK. TARBIYAH ONM", 1);
        graph.get("JL G").put("JL A", 1);
        graph.get("JL G").put("JL E", 1);
        graph.get("JL G").put("JL H", 1);
        graph.get("JL G").put("JL K", 1);

        graph.put("JL H", new HashMap<>());
        graph.get("JL H").put("ASRAMA PUTRI", 1);
        graph.get("JL H").put("FAPERTAPET F", 1);
        graph.get("JL H").put("JL G", 1);

        graph.put("JL I", new HashMap<>());
        graph.get("JL I").put("LABOR FASTE", 1);
        graph.get("JL I").put("FAK. SAINTEK K", 1);
        graph.get("JL I").put("JL A", 1);

        graph.put("JL J", new HashMap<>());
        graph.get("JL J").put("ASRAMA PUTRA", 1);
        graph.get("JL J").put("JL A", 1);
        graph.get("JL J").put("JL C", 1);
        graph.get("JL J").put("JL BULUH CINA", 100);

        graph.put("JL K", new HashMap<>());
        graph.get("JL K").put("GEDUNG BARU",1);
        graph.get("JL K").put("JL G",1);

        graph.put("JL BULUH CINA", new HashMap<>());
        graph.get("JL BULUH CINA").put("JL A", 100);
        graph.get("JL BULUH CINA").put("JL J", 100);


    }

    private void initUI() {
        Rectangle2D primer = Screen.getPrimary().getVisualBounds();

        Image appIcon = new Image("C:\\Users\\HP\\Pictures\\map.png");
        window.getIcons().add(appIcon);

        StackPane layout1 = new StackPane();
        Image screen1 = new Image("C:\\Users\\HP\\Pictures\\scene (2).jpeg");
        BackgroundImage screen = new BackgroundImage(
                screen1,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(primer.getWidth(), primer.getHeight(), false, false, false, false)
        );
        layout1.setBackground(new Background(screen));

        Button Start = new Button("START");
        Start.setOnAction(e -> {
            window.setScene(scene2);
            result.clear();
            fromTf.clear();
            toTf.clear();
        });
        Start.setPrefSize(210,70);
        Start.setStyle(
                "-fx-background-color: SKYBLUE;" +
                "-fx-background-radius: 45;"+
                "-fx-font-size: 3em; /* 25 */" +
                "-fx-border-color: Black;" +
                "-fx-border-width: 0;" +
                "-fx-font-family: 'Rockwell Extra Bold';"+
                "-fx-text-fill: Black;"+
                "-fx-alignment: CENTER;" +
                "-fx-min-width: " + Start.getPrefWidth() + "px;" +
                "-fx-min-height: " + Start.getPrefHeight() + "px;"
        );
        Start.setOnMouseEntered(e -> {
            Start.setStyle(
                    "-fx-background-color: Black;" +
                    "-fx-background-radius: 45;" +
                    "-fx-font-size: 3em; /* 25 */" +
                    "-fx-border-color: transparent;" +
                    "-fx-border-width: 0;" +
                    "-fx-font-family: 'Rockwell Extra Bold';"+
                    "-fx-border-style: solid, segments(1, 2);" +
                    "-fx-text-fill:SKYBLUE;"+
                    "-fx-alignment: CENTER;" +
                    "-fx-min-width: " + Start.getPrefWidth() + "px;" +
                    "-fx-min-height: " + Start.getPrefHeight() + "px;"
            );
        });
        Start.setOnMouseExited(e -> {
            Start.setStyle(
                    "-fx-background-radius: 45;"+
                    "-fx-border-color: Black;" +
                    "-fx-border-width: 0;" +
                    "-fx-background-color: SKYBLUE;" +
                    "-fx-font-family: 'Rockwell Extra Bold';"+
                    "-fx-font-size: 3em; /* 25 */" +
                    "-fx-text-fill: Black;"+
                    "-fx-alignment: CENTER;" +
                    "-fx-min-width: " + Start.getPrefWidth() + "px;" +
                    "-fx-min-height: " + Start.getPrefHeight() + "px;"
            );
        });



        layout1.getChildren().addAll(Start);

        StackPane.setAlignment(Start, Pos.BOTTOM_CENTER);
        StackPane.setMargin(Start, new Insets(0, 0, 25, 0));

        scene1 = new Scene(layout1, primer.getWidth(), primer.getHeight());
        //-----------------------------------------------------------------------

        Label title = new Label("Shortest Path Search");
        title.setStyle("-fx-font-family: 'Constantia';" +
                        "-fx-font-size: 35px;");

        Button start = new Button("Start");
        start.setOnAction(e -> handleStartButton());

        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            fromTf.setText("");
            toTf.setText("");
            result.setText("");

        });

        Button back = new Button("Back");
        back.setOnAction(e -> window.setScene(scene1));

        fromTf = new TextField();
        toTf = new TextField();
        result = new TextArea();
        result.setPrefSize(400,350);

        HBox formBox = new HBox(10,
                new Label("FROM :"), fromTf,
                new Label("TO   :"), toTf,
                start, clear, back);

        VBox resultBox = new VBox(10,
                new Label("RESULT :"), result);
        resultBox.setStyle("-fx-border-color: black;");
        resultBox.setPadding(new Insets(10));
        resultBox.setPrefSize(400,600);

        result.setStyle("-fx-font-family: 'Segoe UI', Helvetica, Arial, sans-serif;" +
                "-fx-font-size: 14px;");

        VBox mainBox = new VBox(15, title, formBox, resultBox);
        mainBox.setBackground(new Background(new BackgroundFill(javafx.scene.paint.Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        mainBox.setPadding(new Insets(10));

        // Create a slot for the image on the right
        StackPane imageSlot = new StackPane();
        imageSlot.setStyle("-fx-border-color: black;");
        imageSlot.setMinWidth(800); // Set the width as needed
        imageSlot.setPadding(new Insets(2));

        Image mapImage = new Image("C:\\Users\\HP\\Pictures\\mapsss.jpg");
        ImageView imageView = new ImageView(mapImage);
        imageView.setFitWidth(780);
        imageView.setPreserveRatio(true);

        imageSlot.getChildren().add(imageView);


        BorderPane borderPane = new BorderPane();
        borderPane.setRight(imageSlot);
        borderPane.setLeft(mainBox);

        scene2 = new Scene(borderPane, primer.getWidth(), primer.getHeight());
        window.setScene(scene2);
    }

    private void handleStartButton() {
        String inputFromTf = fromTf.getText().trim();
        String inputToTf = toTf.getText().trim();

        if (inputFromTf.isEmpty() || inputToTf.isEmpty()) {
            warning("Masukkan input untuk FROM dan TO!");
            return;
        }
        result.clear();
        startNode = inputFromTf.toUpperCase();
        endNode = inputToTf.toUpperCase();
        result.clear();

        List<PathWithWeight> allPaths = findAllPathsWithWeight(graph, startNode, endNode);
        if (allPaths.isEmpty()) {
            result.setText("Tidak ada jalur dari " + startNode + " ke " + endNode);
        } else {
            allPaths.sort(Comparator.comparingInt(PathWithWeight::getWeight));
            StringBuilder resultText = new StringBuilder();
            for (int i = 0; i <allPaths.size(); i++) {
                PathWithWeight pathWithWeight = allPaths.get(i);
                resultText.append(i + 1).append(". Jalur terpendek dari ").append(startNode)
                        .append(" ke ").append(endNode).append(" : \n")
                        .append(pathWithWeight.getPath().stream().collect(Collectors.joining(" -> ")))
                        .append("\nJarak: ")
                        .append(pathWithWeight.getWeight()).append("Km\n");
            }
            result.setText(resultText.toString());
        }
    }
    private void warning(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    static class PathWithWeight {
        List<String> path;
        int weight;

        public PathWithWeight(List<String> path, int weight) {
            this.path = path;
            this.weight = weight;
        }

        public List<String> getPath() {
            return path;
        }

        public int getWeight() {
            return weight;
        }
    }

    private List<PathWithWeight> findAllPathsWithWeight(Map<String, Map<String, Integer>> graph, String start, String end) {
        List<PathWithWeight> allPaths = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        List<String> currentPath = new ArrayList<>();
        dfsWithWeight(graph, start, end, visited, currentPath, allPaths);
        return allPaths;
    }

    private void dfsWithWeight(Map<String, Map<String, Integer>> graph, String current, String end, Set<String> visited, List<String> currentPath, List<PathWithWeight> allPaths) {
        visited.add(current);
        currentPath.add(current);

        if (current.equals(end)) {
            int weight = calculatePathWeight(graph, currentPath);
            allPaths.add(new PathWithWeight(new ArrayList<>(currentPath), weight));
        } else {
            Map<String, Integer> currentRelations = graph.get(current);
            if (currentRelations != null) {
                for (Map.Entry<String, Integer> relation : currentRelations.entrySet()) {
                    if (!visited.contains(relation.getKey())) {
                        dfsWithWeight(graph,relation.getKey(),end,visited,currentPath,allPaths);
                    }
                }
            }
        }

        visited.remove(current);
        currentPath.remove(currentPath.size() - 1);
    }


    private int calculatePathWeight(Map<String, Map<String, Integer>> graph, List<String> path) {
        int weight = 0;
        for (int i = 0; i < path.size() - 1; i++) {
            String current = path.get(i);
            String next = path.get(i + 1);
            weight += graph.get(current).get(next);
        }
        return weight;
    }

}
