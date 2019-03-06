#!/usr/bin/env groovy

//////////////////////////////////////////////////////////////////////////
//
//           以下脚本代码不随特定编译过程改变，没有必要不要轻易调整
//
//////////////////////////////////////////////////////////////////////////
// 加载特定版本的library，不带分支信息使用jenkins默认的配置，显示指定特定的分支
// 一般用于调式才需要指定特定分支，否则使用全局统一配置,目前默认为3.0.0
// library "library@1.0.0"
library "cloudtv3_library"

// 调用cloudt下的loadConfig.groovy文件里的call函数
def config = [
		//邮件列表,使用,进行分割
		mailRecepiant: 'lijl-c',
		//默认的配置项目,根据情况进行自定义
		//配置在哪个节点上运行
		//nodeName: "cloudt",
		//maven的配置文件,配置了发布库(外网阿里云的nexus)以及获取哪些库的信息
		//mavenSettingsConfig: "maven-config-cloudt-v3",
		//默认的发布库-发布到jfrog的部分--不同的产品采用不同的库进行区分
		//artiReleaseRepo: 'maven-zhenggl-release',
		//artiSnapshotRepo: 'maven-zhenggl-snapshot'
]
//调用构造过程,此构造过程定义了默认的构造流程,不建议进行改动
runBuildPipeline(config)


