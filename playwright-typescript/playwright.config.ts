import { defineConfig, devices } from "@playwright/test";
import { loadEnvConfig } from "@next/env";

loadEnvConfig(process.cwd());

export default defineConfig({
  testDir: "./tests",
  fullyParallel: true,
  forbidOnly: !!process.env.CI,
  retries: process.env.CI ? 2 : 0,
  workers: process.env.CI ? 1 : undefined,
  reporter: [
    ["allure-playwright", { detail: true, resultsDir: "allure-results" }],
    ["html", { open: "never", outputFolder: "playwright-report/testHTMLReports" }],
    ["junit", { outputFile: "playwright-report/testXMLFiles/results.xml" }],
  ],
  use: {
    trace: "on-first-retry",
    video: "on",
    screenshot: "on",
  },
  projects: [
    { name: "chromium", use: { ...devices["Desktop Chrome"] } },
    { name: "firefox", use: { ...devices["Desktop Firefox"] } },
    { name: "webkit", use: { ...devices["Desktop Safari"] } },
  ],
});
