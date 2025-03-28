const base = {
    get() {
        return {
            url : "http://localhost:8080/nongchanpinzhihuiwuliu/",
            name: "nongchanpinzhihuiwuliu",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/nongchanpinzhihuiwuliu/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "农产品智慧物流系统"
        } 
    }
}
export default base
