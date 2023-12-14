<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = $_POST["Name"];
    $email = $_POST["Email"];
    $message = $_POST["Message"];

    // Create a new row with user information
    $data = array($name, $email, $message);

    // Append the data to an Excel file (you need to adjust the file path)
    $file = 'user_data.xlsx';
    if (file_exists($file)) {
        $excelData = array_map('str_getcsv', file($file));
    } else {
        $excelData = array();
    }
    
    $excelData[] = $data;

    // Write the data back to the Excel file
    $fp = fopen($file, 'w');
    foreach ($excelData as $fields) {
        fputcsv($fp, $fields);
    }
    fclose($fp);
}
?>
