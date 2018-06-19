"use strict";

const expect = require("chai").expect;
const codecheck = require("codecheck");
const app = codecheck.consoleApp(process.env.APP_COMMAND);
const testcases = require('./cases.json');

describe("'3 バカ' CLIアプリケーションは", () => {
  testcases.forEach(testcase => {
    it(testcase.it, () => {
      return app.codecheck(testcase.input.split(" "))
      .then(result => {
        expect(result.code).to.equal(0,
          "CLIアプリケーションはステータスコード0で終了しなければならない。");
        expect(result.stdout).to.deep.equal(testcase.output);
      });
    });
  });
});
