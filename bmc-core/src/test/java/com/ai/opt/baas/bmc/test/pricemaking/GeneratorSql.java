package com.ai.opt.baas.bmc.test.pricemaking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GeneratorSql {
    public static void main(String[] args) throws EncryptedDocumentException,
            InvalidFormatException, IOException {
        ecsInstance();
        // ecsDisk();
        rds();
        kvs();
        System.out.println("success");
    }

    private static void kvs() throws EncryptedDocumentException, InvalidFormatException,
            IOException {
        List<String> payTypes = new ArrayList<String>();
        payTypes.add("Postpaid");
        payTypes.add("Prepaid");
        long productId = 95001L;
        String tenantId = "#tenant_id";
        Workbook workbook = WorkbookFactory.create(new File("E:/产品.xlsx"));
        Sheet sheet = workbook.getSheetAt(6);
        // factor
        StringBuilder builder = new StringBuilder();
        builder.append("insert into cp_pricemaking_factor");
        builder.append("\n");
        builder.append("(tenant_id, price_product_type, price_product_id, factor_name, factor_value)");
        builder.append("\n");
        builder.append("values");
        builder.append("\n");
        // rule
        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into cp_pricemaking_rule");
        builder2.append("\n");
        builder2.append("(tenant_id, price_product_type, price_product_id, price_type, rule_code, rule_expresion, ext_info, price_unit)");
        builder2.append("\n");
        builder2.append("values");
        builder2.append("\n");
        for (int i = 1; i < 9; i++) {
            Row row = sheet.getRow(i);
            String capacity = row.getCell(3).getStringCellValue();
            String regionId = row.getCell(1).getStringCellValue();
            double price = row.getCell(6).getNumericCellValue();
            builder.append("('" + tenantId + "', 'KVS', '" + productId + "', 'RegionId', '"
                    + regionId + "'),");
            builder.append("\n");
            builder.append("('" + tenantId + "', 'KVS', '" + productId + "', 'Capacity', '"
                    + capacity + "'),");
            builder.append("\n");

            builder2.append("('" + tenantId + "', 'KVS', '" + productId
                    + "', 'PER_HOUR', 'CONST', '" + (long) (price * 1000) + "', '', 'h'),");
            builder2.append("\n");

            productId++;
        }

        String fileName = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/kvs-instance-factor.sql";
        String fileName2 = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/kvs-instance-rule.sql";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));
        out.println(builder.toString());
        out2.println(builder2.toString());
        out.close();
        out2.close();
    }

    private static void rds() throws EncryptedDocumentException, InvalidFormatException,
            IOException {
        List<String> payTypes = new ArrayList<String>();
        payTypes.add("Postpaid");
        payTypes.add("Prepaid");
        long productId = 94001L;
        String tenantId = "#tenant_id";
        Workbook workbook = WorkbookFactory.create(new File("E:/产品.xlsx"));
        Sheet sheet = workbook.getSheetAt(3);
        // factor
        StringBuilder builder = new StringBuilder();
        builder.append("insert into cp_pricemaking_factor");
        builder.append("\n");
        builder.append("(tenant_id, price_product_type, price_product_id, factor_name, factor_value)");
        builder.append("\n");
        builder.append("values");
        builder.append("\n");
        // rule
        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into cp_pricemaking_rule");
        builder2.append("\n");
        builder2.append("(tenant_id, price_product_type, price_product_id, price_type, rule_code, rule_expresion, ext_info, price_unit)");
        builder2.append("\n");
        builder2.append("values");
        builder2.append("\n");
        for (String payType : payTypes) {
            for (int i = 2; i < 14; i++) {
                Row row = sheet.getRow(i);
                String engine = row.getCell(1).getStringCellValue();
                String regionId = row.getCell(3).getStringCellValue();
                String dBInstanceClass = row.getCell(4).getStringCellValue();
                double price = row.getCell(9).getNumericCellValue();
                builder.append("('" + tenantId + "', 'RDS', '" + productId + "', 'RegionId', '"
                        + regionId + "'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId + "', 'Engine', '"
                        + engine + "'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId
                        + "', 'DBInstanceClass', '" + dBInstanceClass + "'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId
                        + "', 'DBInstanceNetType', 'Internet'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId + "', 'PayType', '"
                        + payType + "'),");
                builder.append("\n");

                builder2.append("('" + tenantId + "', 'RDS', '" + productId
                        + "', 'PER_HOUR', 'EXPR', '" + (long) (price * 1000)
                        + "+#{DBInstanceStorage}*1.7', '', 'h'),");
                builder2.append("\n");

                productId++;
            }

            for (int i = 17; i < 26; i++) {
                Row row = sheet.getRow(i);
                String engine = row.getCell(1).getStringCellValue();
                String regionId = row.getCell(3).getStringCellValue();
                String dBInstanceClass = row.getCell(4).getStringCellValue();
                double price = row.getCell(9).getNumericCellValue();
                builder.append("('" + tenantId + "', 'RDS', '" + productId + "', 'RegionId', '"
                        + regionId + "'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId + "', 'Engine', '"
                        + engine + "'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId
                        + "', 'DBInstanceClass', '" + dBInstanceClass + "'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId
                        + "', 'DBInstanceNetType', 'Internet'),");
                builder.append("\n");
                builder.append("('" + tenantId + "', 'RDS', '" + productId + "', 'PayType', '"
                        + payType + "'),");
                builder.append("\n");

                builder2.append("('" + tenantId + "', 'RDS', '" + productId
                        + "', 'PER_HOUR', 'EXPR', '" + (long) (price * 1000)
                        + "+#{DBInstanceStorage}*1.7', '', 'h'),");
                builder2.append("\n");

                productId++;
            }
        }

        String fileName = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/rds-instance-factor.sql";
        String fileName2 = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/rds-instance-rule.sql";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));
        out.println(builder.toString());
        out2.println(builder2.toString());
        out.close();
        out2.close();
    }

    private static void ecsDisk() throws IOException {
        long productId = 92001L;
        String regionId = "cn-beijing";
        List<String> categorys = new ArrayList<String>();
        categorys.add("cloud");
        categorys.add("cloud_efficiency");
        categorys.add("cloud_ssd");
        categorys.add("ephemeral_ssd");

        // factor
        StringBuilder builder = new StringBuilder();
        builder.append("insert into cp_pricemaking_factor");
        builder.append("\n");
        builder.append("(tenant_id, price_product_type, price_product_id, factor_name, factor_value)");
        builder.append("\n");
        builder.append("values");
        builder.append("\n");
        // rule
        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into cp_pricemaking_rule");
        builder2.append("\n");
        builder2.append("(tenant_id, price_product_type, price_product_id, price_type, rule_code, rule_expresion, ext_info, price_unit)");
        builder2.append("\n");
        builder2.append("values");
        builder2.append("\n");

        for (String category : categorys) {
            builder.append("('#tenant_id', 'ECS-SYSTEM-DISK', '");
            builder.append(productId);
            builder.append("', 'RegionId', '");
            builder.append(regionId);
            builder.append("'),");
            builder.append("\n");
            builder.append("('#tenant_id', 'ECS-SYSTEM-DISK', '");
            builder.append(productId);
            builder.append("', 'SystemDisk.Category', '");
            builder.append(category);
            builder.append("'),");
            builder.append("\n");

            builder2.append("('#tenant_id', 'ECS-SYSTEM-DISK', '");
            builder2.append(productId);
            builder2.append("', 'PER_HOUR', 'EXPR', '#{SystemDisk.Size}', '', 'h'),");
            builder2.append("\n");

            productId++;
        }
        for (String category : categorys) {
            builder.append("('#tenant_id', 'ECS-DATA-DISK', '");
            builder.append(productId);
            builder.append("', 'RegionId', '");
            builder.append(regionId);
            builder.append("'),");
            builder.append("\n");
            builder.append("('#tenant_id', 'ECS-DATA-DISK', '");
            builder.append(productId);
            builder.append("', 'DataDisk.n.Category', '");
            builder.append(category);
            builder.append("'),");
            builder.append("\n");

            builder2.append("('#tenant_id', 'ECS-DATA-DISK', '");
            builder2.append(productId);
            builder2.append("', 'PER_HOUR', 'EXPR', '#{DataDisk.n.Size}', '', 'h'),");
            builder2.append("\n");

            productId++;
        }

        String fileName = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/ecs-disk-factor.sql";
        String fileName2 = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/ecs-disk-rule.sql";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));
        out.println(builder.toString());
        out2.println(builder2.toString());
        out.close();
        out2.close();
    }

    private static void ecsInstance() throws EncryptedDocumentException, InvalidFormatException,
            IOException {
        long productId = 91001L;
        Workbook workbook = WorkbookFactory.create(new File("E:/产品.xlsx"));
        Sheet sheet = workbook.getSheetAt(0);
        // factor
        StringBuilder builder = new StringBuilder();
        builder.append("insert into cp_pricemaking_factor");
        builder.append("\n");
        builder.append("(tenant_id, price_product_type, price_product_id, factor_name, factor_value)");
        builder.append("\n");
        builder.append("values");
        builder.append("\n");
        // rule
        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into cp_pricemaking_rule");
        builder2.append("\n");
        builder2.append("(tenant_id, price_product_type, price_product_id, price_type, rule_code, rule_expresion, ext_info, price_unit)");
        builder2.append("\n");
        builder2.append("values");
        builder2.append("\n");

        for (int i = 2; i < 15; i++) {
            Row row = sheet.getRow(i);
            String regionId = row.getCell(3).getStringCellValue();
            String instanceType = row.getCell(5).getStringCellValue();
            double price = row.getCell(8).getNumericCellValue();
            builder.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder.append(productId);
            builder.append("', 'RegionId', '");
            builder.append(regionId);
            builder.append("'),");
            builder.append("\n");
            builder.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder.append(productId);
            builder.append("', 'InstanceType', '");
            builder.append(instanceType);
            builder.append("'),");
            builder.append("\n");

            builder2.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder2.append(productId);
            builder2.append("', 'PER_HOUR', 'CONST', '");
            builder2.append((long) (price * 1000));
            builder2.append("', '', 'h'),");
            builder2.append("\n");

            productId++;
        }
        for (int i = 18; i < 36; i++) {
            Row row = sheet.getRow(i);
            String regionId = row.getCell(3).getStringCellValue();
            String instanceType = row.getCell(5).getStringCellValue();
            double price = row.getCell(8).getNumericCellValue();
            builder.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder.append(productId);
            builder.append("', 'RegionId', '");
            builder.append(regionId);
            builder.append("'),");
            builder.append("\n");
            builder.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder.append(productId);
            builder.append("', 'InstanceType', '");
            builder.append(instanceType);
            builder.append("'),");
            builder.append("\n");

            builder2.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder2.append(productId);
            builder2.append("', 'PER_HOUR', 'CONST', '");
            builder2.append((long) (price * 1000));
            builder2.append("', '', 'h'),");
            builder2.append("\n");

            productId++;
        }
        for (int i = 39; i < 57; i++) {
            Row row = sheet.getRow(i);
            String regionId = row.getCell(3).getStringCellValue();
            String instanceType = row.getCell(5).getStringCellValue();
            double price = row.getCell(8).getNumericCellValue();
            builder.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder.append(productId);
            builder.append("', 'RegionId', '");
            builder.append(regionId);
            builder.append("'),");
            builder.append("\n");
            builder.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder.append(productId);
            builder.append("', 'InstanceType', '");
            builder.append(instanceType);
            builder.append("'),");
            builder.append("\n");

            builder2.append("('#tenant_id', 'ECS-INSTANCE', '");
            builder2.append(productId);
            builder2.append("', 'PER_HOUR', 'CONST', '");
            builder2.append((long) (price * 1000));
            builder2.append("', '', 'h'),");
            builder2.append("\n");

            productId++;
        }

        String fileName = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/ecs-instance-factor.sql";
        String fileName2 = "E:/BIU-BaaS/02.Requirement Doc/03.Product Req/计费需求/中信/定价脚本/ecs-instance-rule.sql";
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
        PrintWriter out2 = new PrintWriter(new BufferedWriter(new FileWriter(fileName2)));
        out.println(builder.toString());
        out2.println(builder2.toString());
        out.close();
        out2.close();
    }
}
