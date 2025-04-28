/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Components.EnemyFabric;
import Components.Player;
import Components.Items;
import Components.GameCharacter;
import Components.GameResults;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static Components.CharacterName.*;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/**
 *
 * @author maria
 */
public class Helper {
    public Logic action = new Logic();
    public Fight fight = new Fight();
    private final ArrayList<GameResults> gameResults = new ArrayList<>();
    private final GameCharacter[] enemies = new GameCharacter[5];

    EnemyFabric fabric = new EnemyFabric();

    public void setEnemies() {
        enemies[0] = fabric.create(BARAKA);
        enemies[1] = fabric.create(SUB_ZERO);
        enemies[2] = fabric.create(LIU_KANG);
        enemies[3] = fabric.create(SONYA_BLADE);
        enemies[4] = fabric.create(SHAO_KAHN);
    }

    public GameCharacter[] getEnemies() {
        return this.enemies;
    }

    public Player newHuman(Mediator mediator, Items[] items) {
        Player player = new Player(0, 80, 16, You);
        mediator.setHealthBar(player);
        mediator.setPlayerMaxHealthBar(player);
        player.setItems(items);
        return player;
    }

    public void endGameTop(Player player, JTextField text, JTable table) throws IOException {
        gameResults.add(new GameResults(text.getText(), player.getPoints()));
        gameResults.sort(Comparator.comparing(GameResults::getPoints).reversed());
        writeToTable(table);
        writeToExcel();
    }

    public void writeToExcel() throws IOException {
//        try (XSSFWorkbook book = new XSSFWorkbook()) {
//            XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
//            XSSFRow r = sheet.createRow(0);
//            r.createCell(0).setCellValue("№");
//            r.createCell(1).setCellValue("Имя");
//            r.createCell(2).setCellValue("Количество баллов");
//            for (int i = 0; i < gameResults.size(); i++) {
//                if (i < 10) {
//                    XSSFRow r2 = sheet.createRow(i + 1);
//                    r2.createCell(0).setCellValue(i + 1);
//                    r2.createCell(1).setCellValue(gameResults.get(i).getName());
//                    r2.createCell(2).setCellValue(gameResults.get(i).getPoints());
//                }
//            }
//            File file = new File(System.getProperty("java.class.path"));
//            File dir = file.getAbsoluteFile().getParentFile();
//            String path = dir.toString();
//            File f = new File(path +"/"+ "Results.xlsx");
//            book.write(new FileOutputStream(f));
//        }

//        try (XSSFWorkbook book = new XSSFWorkbook()) {
//        XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
//        XSSFRow r = sheet.createRow(0);
//        r.createCell(0).setCellValue("№");
//        r.createCell(1).setCellValue("Имя");
//        r.createCell(2).setCellValue("Количество баллов");
//        
//        for (int i = 0; i < gameResults.size() && i < 10; i++) {
//            XSSFRow r2 = sheet.createRow(i + 1);
//            r2.createCell(0).setCellValue(i + 1);
//            r2.createCell(1).setCellValue(gameResults.get(i).getName());
//            r2.createCell(2).setCellValue(gameResults.get(i).getPoints());
//        }
//        
//        // Получаем путь к директории приложения
//        String path = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
//        File f = new File(path, "Results.xlsx");
//        
//        try (FileOutputStream out = new FileOutputStream(f)) {
//            book.write(out);
//        }
//    } catch (URISyntaxException e) {
//        throw new IOException("Ошибка в URI", e);
//    }
//        
        File externalFile = new File("Results.xlsx");
    
        try (XSSFWorkbook book = new XSSFWorkbook()) {
            XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
            XSSFRow r = sheet.createRow(0);
            r.createCell(0).setCellValue("№");
            r.createCell(1).setCellValue("Имя");
            r.createCell(2).setCellValue("Количество баллов");

            for (int i = 0; i < gameResults.size() && i < 10; i++) {
                XSSFRow r2 = sheet.createRow(i + 1);
                r2.createCell(0).setCellValue(i + 1);
                r2.createCell(1).setCellValue(gameResults.get(i).getName());
                r2.createCell(2).setCellValue(gameResults.get(i).getPoints());
            }
        
        try (FileOutputStream out = new FileOutputStream(externalFile)) {
            book.write(out);
        }
    }
    }

    public ArrayList<GameResults> getResults() {
        return this.gameResults;
    }

    public void readFromExcel() throws IOException {
//        File file = new File(System.getProperty("java.class.path"));
//        File dir = file.getAbsoluteFile().getParentFile();
//        String path = dir.toString();
//        XSSFWorkbook book = new XSSFWorkbook(path +"/"+ "Results.xlsx");
//        XSSFSheet sh = book.getSheetAt(0);
//        for (int i = 1; i <= sh.getLastRowNum(); i++) {
//            gameResults.add(new GameResults(sh.getRow(i).getCell(1).getStringCellValue(), (int) sh.getRow(i).getCell(2).getNumericCellValue()));
//        }

//        try {
//        // Получаем путь к директории приложения
//        String path = new File(getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
//        File file = new File(path, "Results.xlsx");
//        
//        if (file.exists()) {
//            try (XSSFWorkbook book = new XSSFWorkbook(file)) {
//                XSSFSheet sh = book.getSheetAt(0);
//                for (int i = 1; i <= sh.getLastRowNum(); i++) {
//                    XSSFRow row = sh.getRow(i);
//                    if (row != null) {
//                        String name = row.getCell(1).getStringCellValue();
//                        int points = (int) row.getCell(2).getNumericCellValue();
//                        gameResults.add(new GameResults(name, points));
//                    }
//                }
//            } catch (InvalidFormatException ex) {
//                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
//        } catch (URISyntaxException e) {
//            throw new IOException("Ошибка в URI", e);
//        }
         // Путь к файлу во внешней директории
        File externalFile = new File("Results.xlsx");

        // Если файл существует вне JAR - читаем его
        if (externalFile.exists()) {
            try (XSSFWorkbook book = new XSSFWorkbook(externalFile)) {
                readDataFromWorkbook(book);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        // Если нет - копируем из ресурсов и читаем
        else {
            try (InputStream is = getClass().getResourceAsStream("/Results.xlsx");
                 XSSFWorkbook book = new XSSFWorkbook(is)) {

                // Копируем файл из ресурсов в рабочую директорию
                try (FileOutputStream out = new FileOutputStream(externalFile)) {
                    book.write(out);
                }

                readDataFromWorkbook(book);
            }
        }
    }
    
    private void readDataFromWorkbook(XSSFWorkbook book) {
    XSSFSheet sh = book.getSheetAt(0);
    for (int i = 1; i <= sh.getLastRowNum(); i++) {
        XSSFRow row = sh.getRow(i);
        if (row != null) {
            String name = row.getCell(1).getStringCellValue();
            int points = (int) row.getCell(2).getNumericCellValue();
            gameResults.add(new GameResults(name, points));
        }
    }
}

    public void writeToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < gameResults.size(); i++) {
            if (i < 10) {
                model.setValueAt(gameResults.get(i).getName(), i, 0);
                model.setValueAt(gameResults.get(i).getPoints(), i, 1);
            }
        }
    }
}
