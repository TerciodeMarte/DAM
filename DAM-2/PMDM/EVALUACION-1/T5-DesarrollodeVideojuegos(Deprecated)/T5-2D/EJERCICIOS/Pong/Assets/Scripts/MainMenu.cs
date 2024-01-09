using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class MainMenu : MonoBehaviour
{

    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Escape))
        {
            exit();
        }

    }

    //Metodo para ser ejecutado cuando se de al boton play
    public void play()
    {
        SceneManager.LoadScene("Pong");
    }

    //Metodo para ser ejecutado cuando se de al boton exit
    public void exit()
    {
        Application.Quit();
    }

}
