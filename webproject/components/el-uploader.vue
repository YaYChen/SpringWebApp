<template>
    <el-upload
        class="upload-demo"
        action="http://localhost:8080/upload-img"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :before-remove="beforeRemove"
        multiple
        :limit="1"
        :on-exceed="handleExceed"
        :on-success="handleAvatarSuccess"
        :file-list="fileList">
        <el-button size="small" type="primary" class="upload_button">Upload Img</el-button>
        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
    </el-upload>
</template>

<script>
  export default {
    props:['fileName'],
    data() {
      return {
        fileList: []
      };
    },
    methods: {
      handleRemove(file, fileList) {
      },
      handlePreview(file) {
      },
      handleExceed(files, fileList) {
        this.$message.warning(`当前限制选择 1 个文件，本次选择了 ${files.length} 个文件，共选择了 ${files.length + fileList.length} 个文件`);
      },
      beforeRemove(file, fileList) {
        return this.$confirm(`确定移除 ${ file.name }？`);
      },
      handleAvatarSuccess(res, file) {
        alert('Upload img success!');
        this.$emit('handleAvatarSuccess', file.name);
      }
    }
  }
</script>

<style scoped>
.layout_header{
    height: auto;
    width: 100%;
}
.upload-demo{
  width: 100%;
  height: auto;
}
.upload_button{
  height: 40px;
  width: 100px;
  font-size: 12px;
  background-color: dodgerblue;
}
</style>